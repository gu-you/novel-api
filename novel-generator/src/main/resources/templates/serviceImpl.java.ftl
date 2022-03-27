package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.List;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 *
 * @ClassName: ${table.serviceImplName!}
 * @Description: TODO   ${table.comment!} 服务实现类
 * @author ${author}
 * @date ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

        @Autowired
        public ${table.mapperName} ${table.mapperName?uncap_first};


        /**
         * ${table.comment!}查询列表
         * @param param ${entity?uncap_first}
         * @return
         */
        @Override
        public List<${entity}> select${entity}List(${entity} ${entity?uncap_first}) {
            List<${entity}> list = ${table.mapperName?uncap_first}.select${entity}List(${entity?uncap_first});
            return list;
        }

        /**
         * ${table.comment!}详情(单个条目)
         * @param id 主键
         * @return
         */
        @Override
        public ${entity} select${entity}ById(Integer id) {
            ${entity} result = ${table.mapperName?uncap_first}.select${entity}ById(Integer id);
            return result;
        }

        /**
         * ${table.comment!}详情(多个条目)
         * @param ids 主键数组
         * @return ${entity}
         */
        @Override
        public List<${entity}> select${entity}ByIds(Integer[] ids) {
            List<${entity}> result = ${table.mapperName?uncap_first}.select${entity}ByIds(ids);
            return result;
        }

        /**
         * ${table.comment!}新增
         * @param param ${entity?uncap_first}
         * @return
         */
        @Override
        @Transactional
        public int insert${entity}(${entity} ${entity?uncap_first}){
            param.setCreateAt(new Date());
            return ${table.mapperName?uncap_first}.insert${entity}(${entity} ${entity?uncap_first});
        }

        /**
         * ${table.comment!}修改
         * @param param ${entity?uncap_first}
         * @return
         */
        @Override
        @Transactional
        public int update${entity}(${entity} ${entity?uncap_first}) {
            param.setUpdateAt(new Date());
            return ${table.mapperName?uncap_first}.update${entity}(${entity?uncap_first});
        }

        /**
         * ${table.comment!}删除(单个条目)
         * @param id 主键
         * @return
         */
        @Override
        public int delete${entity}ById(Integer id) {
            return ${table.mapperName?uncap_first}.delete${entity}ById(id);
        }

        /**
         * ${table.comment!}删除(多个条目)
         * @param ids 主键数组
         * @return
         */
        @Override
        public int delete${entity}ByIds(Integer[] ids){
            return ${table.mapperName?uncap_first}.delete${entity}ByIds(ids);
        }
        }
