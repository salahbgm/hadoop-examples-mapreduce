package com.opstty.reducer;


import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
import com.opstty.writable.AgeDistrictWritable;
import org.apache.hadoop.io.Text;


public class OldestTreeReducer extends Reducer<NullWritable, AgeDistrictWritable, Text, NullWritable> {
    @Override
    protected void reduce(NullWritable key, Iterable<AgeDistrictWritable> values, Context context) throws IOException, InterruptedException {
        AgeDistrictWritable oldest = null;
        for (AgeDistrictWritable value : values) {
            if (oldest == null || value.getAge() > oldest.getAge()) {
                oldest = value;
            }
        }
        if (oldest != null) {
            context.write(new Text(oldest.getDistrict()), NullWritable.get());
        }
    }
}
