package com.opstty.mapper;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opstty.writable.AgeDistrictWritable;


public class OldestTreeMapper extends Mapper<LongWritable, Text, NullWritable, AgeDistrictWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) return; // Ignorer la première ligne
        String[] fields = value.toString().split(";");
        int age = Integer.parseInt(fields[5]); // Supposons que l'âge est dans la sixième colonne
        String district = fields[1]; // Supposons que le district est dans la deuxième colonne
        context.write(NullWritable.get(), new AgeDistrictWritable(age, district));
    }
}
