package com.opstty.reducer;

import com.opstty.writable.AgeDistrictWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OldestTreeReducer extends Reducer<Text, AgeDistrictWritable, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<AgeDistrictWritable> values, Context context) throws IOException, InterruptedException {
        int maxAge = Integer.MIN_VALUE;
        String district = "";

        for (AgeDistrictWritable val : values) {
            if (val.getAge().get() > maxAge) {
                maxAge = val.getAge().get();
                district = val.getDistrict().toString();
            }
        }

        context.write(new Text("District with the oldest tree:"), new Text(district));
    }
}
