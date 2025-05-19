package com.ruoyi.project.system.records.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.records.mapper.BirdRecordsMapper;
import com.ruoyi.project.system.records.domain.BirdRecords;
import com.ruoyi.project.system.records.service.IBirdRecordsService;
import com.ruoyi.common.utils.text.Convert;
import org.springframework.util.CollectionUtils;

/**
 * birdsService业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-19
 */
@Service
public class BirdRecordsServiceImpl implements IBirdRecordsService
{
    @Autowired
    private BirdRecordsMapper birdRecordsMapper;

    /**
     * 查询birds
     * 
     * @param id birds主键
     * @return birds
     */
    @Override
    public BirdRecords selectBirdRecordsById(Long id)
    {
        return birdRecordsMapper.selectBirdRecordsById(id);
    }

    /**
     * 查询birds列表
     * 
     * @param birdRecords birds
     * @return birds
     */
    @Override
    public List<BirdRecords> selectBirdRecordsList(BirdRecords birdRecords)
    {
        return birdRecordsMapper.selectBirdRecordsList(birdRecords);
    }

    /**
     * 新增birds
     * 
     * @param birdRecords birds
     * @return 结果
     */
    @Override
    public int insertBirdRecords(BirdRecords birdRecords)
    {
        birdRecords.setCreateTime(DateUtils.getNowDate());
        return birdRecordsMapper.insertBirdRecords(birdRecords);
    }

    @Override
    public int insertBatchBirdRecords(List<BirdRecords> list,String operName) {
        if(CollectionUtils.isEmpty(list)){
            throw new ServiceException("导入数据不能为空！");
        }
        for (BirdRecords birdRecords : list) {
            birdRecords.setCreateTime(DateUtils.getNowDate());
            birdRecords.setCreateBy(operName);
        }
        int i = birdRecordsMapper.batchInsertBirdRecords(list);
        return i;
    }

    /**
     * 修改birds
     * 
     * @param birdRecords birds
     * @return 结果
     */
    @Override
    public int updateBirdRecords(BirdRecords birdRecords)
    {
        birdRecords.setUpdateTime(DateUtils.getNowDate());
        return birdRecordsMapper.updateBirdRecords(birdRecords);
    }

    /**
     * 批量删除birds
     * 
     * @param ids 需要删除的birds主键
     * @return 结果
     */
    @Override
    public int deleteBirdRecordsByIds(String ids)
    {
        return birdRecordsMapper.deleteBirdRecordsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除birds信息
     * 
     * @param id birds主键
     * @return 结果
     */
    @Override
    public int deleteBirdRecordsById(Long id)
    {
        return birdRecordsMapper.deleteBirdRecordsById(id);
    }
}
