package com.dlink.db.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.dlink.db.annotation.Save;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * SuperEntity
 *
 * @author wenmo
 * @since 2021/5/28
 */
@Setter
@Getter
public class SuperEntity<T extends Model<?>> extends Model<T> implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "名称不能为空", groups = {Save.class})
    private String name;

    @NotNull(message = "是否启用不能为空", groups = {Save.class})
    private Boolean enabled;

    @TableField(fill = FieldFill.INSERT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
