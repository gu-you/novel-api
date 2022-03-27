package ${package.Mapper};

import ${package.Entity}.${table.entityName};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @ClassName: ${table.mapperName!}
 * @Description: TODO   ${table.comment!} 持久层
 * @author ${author}
 * @date ${date}
 */
@Mapper
public interface ${table.mapperName} extends BaseMapper<${table.entityName}> {

        /**
         * ${table.comment!}查询列表
         * @param param ${entity?uncap_first}
         * @return ${entity}
         */
        List<${entity}> select${entity}List(${entity} ${entity?uncap_first});

        /**
         * ${table.comment!}详情(单个条目)
         * @param id 主键
         * @return ${entity}
         */
        ${entity} select${entity}ById(Integer id);

        /**
         * ${table.comment!}详情(多个条目)
         * @param ids 主键数组
         * @return ${entity}
         */
        List<${entity}> select${entity}ByIds(Integer[] ids);

        /**
         * ${table.comment!}新增
         * @param param ${entity?uncap_first}
         * @return
         */
        int insert${entity}(${entity} ${entity?uncap_first});

        /**
         * ${table.comment!}修改
         * @param param ${entity?uncap_first}
         * @return
         */
        int update${entity}(${entity} ${entity?uncap_first});

        /**
         * ${table.comment!}删除(单个条目)
         * @param id 主键
         * @return
         */
        int delete${entity}ById(Integer id);

        /**
        * 删除(多个条目)
        * @param ids 主键数组
        * @return
        */
        int delete${entity}ByIds(Integer[] ids);


        }

