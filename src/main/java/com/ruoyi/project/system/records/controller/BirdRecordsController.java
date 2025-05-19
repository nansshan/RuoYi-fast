package com.ruoyi.project.system.records.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.records.domain.BirdRecords;
import com.ruoyi.project.system.records.service.IBirdRecordsService;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * birdsController
 * 
 * @author ruoyi
 * @date 2025-05-19
 */
@Controller
@RequestMapping("/system/records")
public class BirdRecordsController extends BaseController
{
    private String prefix = "system/records";

    @Autowired
    private IBirdRecordsService birdRecordsService;

    @RequiresPermissions("system:records:view")
    @GetMapping()
    public String records()
    {
        return prefix + "/records";
    }

    /**
     * 查询birds列表
     */
    @RequiresPermissions("system:records:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BirdRecords birdRecords)
    {
        startPage();
        List<BirdRecords> list = birdRecordsService.selectBirdRecordsList(birdRecords);
        return getDataTable(list);
    }

    /**
     * 导出birds列表
     */
    @RequiresPermissions("system:records:export")
    @Log(title = "birds", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BirdRecords birdRecords)
    {
        List<BirdRecords> list = birdRecordsService.selectBirdRecordsList(birdRecords);
        ExcelUtil<BirdRecords> util = new ExcelUtil<BirdRecords>(BirdRecords.class);
        return util.exportExcel(list, "birds数据");
    }

    /**
     * 新增birds
     */
    @RequiresPermissions("system:records:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存birds
     */
    @RequiresPermissions("system:records:add")
    @Log(title = "birds", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BirdRecords birdRecords)
    {
        return toAjax(birdRecordsService.insertBirdRecords(birdRecords));
    }

    /**
     * 修改birds
     */
    @RequiresPermissions("system:records:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BirdRecords birdRecords = birdRecordsService.selectBirdRecordsById(id);
        mmap.put("birdRecords", birdRecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存birds
     */
    @RequiresPermissions("system:records:edit")
    @Log(title = "birds", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BirdRecords birdRecords)
    {
        return toAjax(birdRecordsService.updateBirdRecords(birdRecords));
    }

    /**
     * 删除birds
     */
    @RequiresPermissions("system:records:remove")
    @Log(title = "birds", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(birdRecordsService.deleteBirdRecordsByIds(ids));
    }

    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BirdRecords> util = new ExcelUtil<BirdRecords>(BirdRecords.class);
        List<BirdRecords> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        birdRecordsService.insertBatchBirdRecords(userList,operName);
        return AjaxResult.success("导入成功!");
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BirdRecords> util = new ExcelUtil<BirdRecords>(BirdRecords.class);
        return util.importTemplateExcel("信科检测数据导入模版");
    }
}
