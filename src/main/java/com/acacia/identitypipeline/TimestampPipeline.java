package com.acacia.identitypipeline;

import com.acacia.sdk.AbstractTransform;
import com.google.auto.service.AutoService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;


@AutoService(AbstractTransform.class) //this is needed for Sossity to load the pipeline
public class TimestampPipeline extends AbstractTransform  {

    private static final Logger LOG = LoggerFactory.getLogger(TimestampPipeline.class);

    static final Gson gson = new Gson();

    @Override
    public String transform(String s) {


        //always need to deserialize into a generic object
        Map<String, Object> hm = gson.<Map<String, Object>>fromJson(
                s,
                (new HashMap<String, Object>()).getClass());

        //create a date string
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm.ss.SSSZ");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = new Date();

        //get list of timestamps from incoming data
        List<String> newhm = (List<String>) hm.get("transforms");

        if(newhm == null){
            newhm = new ArrayList<>();
        }

        //append latest timestamp to data
        newhm.add(sdf.format(date));


        //put into map
        hm.put("transforms", newhm);

        //turn back into a JSON string for consumption in other pipelines
        return gson.toJson(hm);
    }

    public TimestampPipeline() {
        super();
    }
}

