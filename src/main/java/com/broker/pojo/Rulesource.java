package com.broker.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Rulesource implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonAlias("scenes_id")
    private String scenesId;

    private String sceneVersion;

    private String areaId;

    private String pointId;

    private String detectionTag;

    private Long detectionNo;

    private String imageId;

    private Long eventTime;

    private String id;

//    @JsonAlias("detection_rule")
//    private List<Detectrule> detectrule;
}
