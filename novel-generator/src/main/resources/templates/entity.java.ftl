package ${package.Entity};

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: ${entity}
 * @Description: TODO   ${table.comment!} 服务类
 * @author ${author}
 * @date ${date}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("${table.comment}")
public class ${entity} extends BaseEntity implements Serializable  {

<#list table.commonFields as value>
    <#if value.comment!="">
        /**
          * ${value.comment}
          */
        @ApiModelProperty(${value.comment})
    </#if>
    private  ${value.propertyType}  ${value.capitalName?uncap_first};
</#list>
<#list table.fields as value>
    <#if value.comment!="">
        /**
        * ${value.comment}
        */
        @ApiModelProperty(${value.comment})
    </#if>
    private  ${value.propertyType}  ${value.capitalName?uncap_first};
</#list>
private Integer[] ids;
}
