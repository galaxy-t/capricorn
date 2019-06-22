package com.galaxyt.capricorn.mongodb.java;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class UserCodec implements Codec<User> {


    /**
     * 往数据库写入的时候进行编码
     * @param writer
     * @param value
     * @param encoderContext
     */
    @Override
    public void encode(BsonWriter writer, User value, EncoderContext encoderContext) {

        writer.writeStartDocument();

        writer.writeString("name", value.getName());


        writer.writeEndDocument();

    }

    /**
     * 从数据库读出的时候进行编码
     * @param reader
     * @param decoderContext
     * @return
     */
    @Override
    public User decode(BsonReader reader, DecoderContext decoderContext) {

        reader.readStartDocument();

        User user = new User();

        user.set_id(reader.readObjectId());
        user.setName(reader.readString("name"));


        reader.readEndDocument();

        return user;
    }



    @Override
    public Class<User> getEncoderClass() {
        return User.class;
    }


}
