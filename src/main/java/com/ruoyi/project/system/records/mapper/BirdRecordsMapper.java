package com.ruoyi.project.system.records.mapper;

import java.util.List;
import com.ruoyi.project.system.records.domain.BirdRecords;

/**
 * birdsMapper接口
 * 
 * @author ruoyi
 * @date 2025-05-19
 */
public interface BirdRecordsMapper 
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

    /**
     * 修改birds
     * 
     * @param birdRecords birds
     * @return 结果
     */
    public int updateBirdRecords(BirdRecords birdRecords);

    /**
     * 删除birds
     * 
     * @param id birds主键
     * @return 结果
     */
    public int deleteBirdRecordsById(Long id);

    /**
     * 批量删除birds
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBirdRecordsByIds(String[] ids);

    /**
     * 批量插入鸟类记录
     *
     * @param birdRecordsList 鸟类记录列表
     * @return 影响行数
     */
    public int batchInsertBirdRecords(List<BirdRecords> birdRecordsList);
}
