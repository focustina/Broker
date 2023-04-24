package com.broker.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 规则记录
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Rulerecord implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String scenesId;

    private String sceneVersion;

    private String areaId;

    private String detectionTag;

    private Long warn;

    private String pointId;

    private String imageId;

    private Long eventTime;


}
