package com.dy.api.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@RestController
@RequestMapping
public interface BaseService<T extends BaseEntity> {

	/**
	 * 保存对象 save
	 * 
	 * @param entity
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@PostMapping("save")
	boolean save(@RequestBody T entity);

	/**
	 * 批量保存对象 saveBatch
	 * 
	 * @param entityList
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@PostMapping("saveBatch")
	default boolean saveBatch(Collection<T> entityList) {
		return saveBatch(entityList, 1000);
	}

	/**
	 * 批量保存对象并指定每次保存的数量 saveBatch
	 * 
	 * @param entityList
	 * @param batchSize
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@PostMapping("saveBatch/batchSize")
	boolean saveBatch(Collection<T> entityList, @RequestParam int batchSize);

	/**
	 * 根据id删除对象 removeById
	 * 
	 * @param id
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@DeleteMapping("removeById")
	boolean removeById(@RequestParam Serializable id);

	/**
	 * 根据字段删除对象 removeByMap
	 * 
	 * @param columnMap
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@DeleteMapping("removeByMap")
	boolean removeByMap(Map<String, Object> columnMap);

	/**
	 * 根据条件删除对象 remove
	 * 
	 * @param queryWrapper
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@DeleteMapping("remove")
	boolean remove(Wrapper<T> queryWrapper);

	/**
	 * 根据id批量删除 removeByIds
	 * 
	 * @param idList
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@DeleteMapping("removeByIds")
	boolean removeByIds(Collection<? extends Serializable> idList);

	/**
	 * 根据id修改对象 updateById
	 * 
	 * @param entity
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@PutMapping("updateById")
	boolean updateById(T entity);

	/**
	 * 根据条件修改 update
	 * 
	 * @param updateWrapper
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@PutMapping("update/updateWrapper")
	boolean update(Wrapper<T> updateWrapper);

	/**
	 * 根据id批量修改 updateBatchById
	 * 
	 * @param entityList
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@PutMapping("updateBatchById")
	default boolean updateBatchById(Collection<T> entityList) {
		return updateBatchById(entityList, 1000);
	}

	/**
	 * 根据id批量修改并指定一次修改多少条 updateBatchById
	 * 
	 * @param entityList
	 * @param batchSize
	 * @return boolean
	 * @author dy 2020年7月13日
	 */
	@PutMapping("updateBatchById/batchSize")
	boolean updateBatchById(Collection<T> entityList, @RequestParam int batchSize);

	/**
	 * 根据id查询 getById
	 * 
	 * @param id
	 * @return T
	 * @author dy 2020年7月13日
	 */
	@GetMapping("getById")
	T getById(@RequestParam Serializable id);

	/**
	 * 根据id集合查询 listByIds
	 * 
	 * @param idList
	 * @return Collection<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("listByIds")
	Collection<T> listByIds(@RequestBody Collection<? extends Serializable> idList);

	/**
	 * 根据字段查询 listByMap
	 * 
	 * @param columnMap
	 * @return Collection<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("listByMap")
	Collection<T> listByMap(@RequestBody Map<String, Object> columnMap);

	/**
	 * 获取唯一对象 getOne
	 * 
	 * @param queryWrapper
	 * @param throwEx
	 * @return T
	 * @author dy 2020年7月13日
	 */
	@GetMapping("getOne/throwEx")
	T getOne(@RequestBody Wrapper<T> queryWrapper);

	/**
	 * 
	 * getMap
	 * 
	 * @param queryWrapper
	 * @return Map<String, Object>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("getMap")
	Map<String, Object> getMap(@RequestBody Wrapper<T> queryWrapper);

	/**
	 * 查数量 count
	 * 
	 * @param queryWrapper
	 * @return int
	 * @author dy 2020年7月13日
	 */
	@GetMapping("count")
	int count(@RequestBody Wrapper<T> queryWrapper);

	/**
	 * 查询 list
	 * 
	 * @param queryWrapper
	 * @return List<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("list")
	List<T> list(@RequestBody Wrapper<T> queryWrapper);

	/**
	 * 分页查询 page
	 * 
	 * @param page
	 * @param queryWrapper
	 * @return IPage<T>
	 * @author dy 2020年7月13日
	 */
	@PostMapping("page/queryWrapper")
	IPage<T> page(@RequestParam long current, @RequestParam long size, @RequestBody Wrapper<T> queryWrapper);

	/**
	 * 分页查询 page
	 * 
	 * @param page
	 * @return IPage<T>
	 * @author dy 2020年7月13日
	 */
	@PostMapping("page")
	Page<T> page(Page<T> page);

	/**
	 * 
	 * listMaps
	 * 
	 * @param queryWrapper
	 * @return List<Map<String, Object>>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("listMaps")
	List<Map<String, Object>> listMaps(@RequestBody Wrapper<T> queryWrapper);

	/**
	 * 
	 * pageMaps
	 * 
	 * @param page
	 * @param queryWrapper
	 * @return IPage<Map<String, Object>>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("pageMaps")
	IPage<Map<String, Object>> pageMaps(@RequestParam long current, @RequestParam long size,
                                        @RequestBody Wrapper<T> queryWrapper);

	/**
	 * 
	 * getBaseMapper
	 * 
	 * @return BaseMapper<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("getBaseMapper")
	BaseMapper<T> getBaseMapper();

	/**
	 * 
	 * query
	 * 
	 * @return QueryChainWrapper<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("query")
	default QueryChainWrapper<T> query() {
		return new QueryChainWrapper<>(getBaseMapper());
	}

	/**
	 * 
	 * lambdaQuery
	 * 
	 * @return LambdaQueryChainWrapper<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("lambdaQuery")
	default LambdaQueryChainWrapper<T> lambdaQuery() {
		return new LambdaQueryChainWrapper<>(getBaseMapper());
	}

	/**
	 * 
	 * update
	 * 
	 * @return UpdateChainWrapper<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("updateWrapper")
	default UpdateChainWrapper<T> updateWrapper() {
		return new UpdateChainWrapper<>(getBaseMapper());
	}

	/**
	 * 
	 * lambdaUpdate
	 * 
	 * @return LambdaUpdateChainWrapper<T>
	 * @author dy 2020年7月13日
	 */
	@GetMapping("lambdaUpdate")
	default LambdaUpdateChainWrapper<T> lambdaUpdate() {
		return new LambdaUpdateChainWrapper<>(getBaseMapper());
	}

}
