package com.opstty.reducer;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxHeightReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    @Override
    protected void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        float maxHeight = 0;
        for (FloatWritable value : values) {
            maxHeight = Math.max(maxHeight, value.get());
        }
        context.write(key, new FloatWritable(maxHeight));
    }
}
