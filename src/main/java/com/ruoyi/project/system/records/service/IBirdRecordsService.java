package com.ruoyi.project.system.records.service;

import java.util.List;
import com.ruoyi.project.system.records.domain.BirdRecords;

/**
 * birdsService接口
 * 
 * @author ruoyi
 * @date 2025-05-19
 */
public interface IBirdRecordsService 
{
    /**
     * 查询birds
     * 
     * @param id birds主键
     * @return birds
     */
    public BirdRecords selectBirdRecordsById(Long id);

    /**
     * 查询birds列表
     * 
     * @param birdRecords birds
     * @return birds集合
     */
    public List<BirdRecords> selectBirdRecordsList(BirdRecords birdRecords);

    /**
     * 新增birds
     * 
     * @param birdRecords birds
     * @return 结果
     */
    public int insertBirdRecords(BirdRecords birdRecords);



    public int insertBatchBirdRecords(List<BirdRecords> list,String operName);

    /**
     * 修改birds
     * 
     * @param birdRecords birds
     * @return 结果
     */
    public int updateBirdRecords(BirdRecords birdRecords);

    /**
     * 批量删除birds
     * 
     * @param ids 需要删除的birds主键集合
     * @return 结果
     */
    public int deleteBirdRecordsByIds(String ids);

    /**
     * 删除birds信息
     * 
     * @param id birds主键
     * @return 结果
     */
    public int deleteBirdRecordsById(Long id);
}
