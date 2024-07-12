package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DistrictsContainingTreesMapper extends Mapper<Object, Text, Text, NullWritable> {
    private Text district = new Text();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if (line.startsWith("ID")) {
            // Skip the header line
            return;
        }
        String[] fields = line.split(";");
        if (fields.length > 1) {
            district.set(fields[1]); // Remplace 1 par l'index correct pour l'arrondissement
            context.write(district, NullWritable.get());
        }
    }
}
