package com.acacia.timestamppipeline;

import com.acacia.sdk.AbstractTransform;
import com.acacia.sdk.AbstractTransformComposer;
import com.google.auto.service.AutoService;

import java.util.ArrayList;
import java.util.List;


@AutoService(AbstractTransformComposer.class)
public class TimestampComposer extends AbstractTransformComposer {

    List<AbstractTransform> transforms = new ArrayList<>();


    public TimestampComposer(){
        super();

        //put all the transformations you want to apply in order, in this list
        transforms.add(new TimestampPipeline());

    }

    @Override
    public List<AbstractTransform> getOrderedTransforms() {
        return transforms;
    }
}
