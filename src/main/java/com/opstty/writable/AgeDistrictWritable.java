package com.opstty.writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

public class AgeDistrictWritable implements Writable {
    private int age;
    private String district;

    public AgeDistrictWritable() {}

    public AgeDistrictWritable(int age, String district) {
        this.age = age;
        this.district = district;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(age);
        out.writeUTF(district);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        age = in.readInt();
        district = in.readUTF();
    }

    public int getAge() {
        return age;
    }

    public String getDistrict() {
        return district;
    }
}