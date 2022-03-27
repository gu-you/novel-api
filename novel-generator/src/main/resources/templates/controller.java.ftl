package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

<#if restControllerStyle>
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>


import javax.validation.Valid;
import java.util.List;

/**
 *
 * @ClassName: ${table.controllerName!}
 * @Description: TODO   ${table.comment!} 服务类
 * @author ${author}
 * @date ${date}
 */
@Api(tags = "${table.comment}")
@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} extends BaseController {

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @GetMapping("/list")
    @ApiOperation(value = "${table.comment}分页列表", response = ${entity}.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
        @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    public PageTable list(${entity} ${entity?uncap_first} ) {
         startPage();
         List<${entity}> list = null;
         try {
            list = ${table.serviceName?uncap_first}.select${entity}List(${entity?uncap_first});
         } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "${table.comment}详情(单个条目)", response = ${entity}.class)
    public AjaxResult info(@PathVariable Integer id) {
        try{
            ${entity} ${entity?uncap_first} = ${table.serviceName?uncap_first}.select${entity}ById(id);
            return success(${entity?uncap_first}, ResultContant.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "${table.comment}详情(多个条目)", response = ${entity}.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try{
            List<${entity}> list = ${table.serviceName?uncap_first}.select${entity}ByIds(ids);
            return success(list, ResultContant.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "${table.comment}新增")
    public AjaxResult add(@RequestBody ${entity} ${entity?uncap_first}) {
       try{
            ${table.serviceName?uncap_first}.insert${entity}(${entity?uncap_first});
            return success(${entity?uncap_first}, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "${table.comment}修改")
    public AjaxResult edit(@RequestBody ${entity} ${entity?uncap_first}) {
       try{
            ${table.serviceName?uncap_first}.update${entity}(${entity?uncap_first});
            return success(${entity?uncap_first},ResultContant.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "${table.comment}删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try{
            ${table.serviceName?uncap_first}.delete${entity}ById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "${table.comment}删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try{
            ${table.serviceName?uncap_first}.delete${entity}ByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
