import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class NettyHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        String message = byteBuf.toString(Charset.defaultCharset());
        System.out.println("Received Message : " + message);
        if(message.equalsIgnoreCase("Hello\r\n")){
            ctx.writeAndFlush(Unpooled.wrappedBuffer("Hello There\r\n".getBytes()));
        }
        if(message.equalsIgnoreCase("Hello There\r\n")){
            ctx.writeAndFlush(Unpooled.wrappedBuffer("Thanks For Reply !!\r\n".getBytes()));
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }
}
