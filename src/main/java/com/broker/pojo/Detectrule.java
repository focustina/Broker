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
public class Detectrule implements Serializable {

    private static final long serialVersionUID=1L;

    private String detectionItem;

    private String pointSubId;

    private String detectionKey;

    private Long detectionValue;

    private Long detectionNo;

    private String imageId;

    private String detectionTag;

    private String pointId;


}
