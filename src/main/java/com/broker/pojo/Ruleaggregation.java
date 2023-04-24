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
 * 
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Ruleaggregation implements Serializable {

    private static final long serialVersionUID=1L;

    private String scenesId;

    private String sceneVersion;

    private String areaId;

    private Long detectionNo;

    private String detectionTag;

    private Long warn;

    private String pointCollect;

    private String imageCollect;

    private Long eventTime;

    private String id;


}
