
package com.opstty.reducer;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTreeDistrictReducer extends Reducer<NullWritable, Text, Text, IntWritable> {
    @Override
    protected void reduce(NullWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String maxDistrict = null;
        int maxCount = 0;

        for (Text value : values) {
            String[] parts = value.toString().split("\t");
            String district = parts[0];
            int count = Integer.parseInt(parts[1]);
            if (count > maxCount) {
                maxCount = count;
                maxDistrict = district;
            }
        }
        context.write(new Text(maxDistrict), new IntWritable(maxCount));
    }
}
