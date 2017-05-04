import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;

public class Main {
    public static void main(String[] args) throws Exception{
        if(args.length == 1){
            ServerFlow.OpenServerPort(12000).channel().closeFuture().sync();
        }
        else{
            try {
                NettyClient nettyClient = new NettyClient(12000);
                ChannelFuture channelFuture = nettyClient.connectLoop();
                Thread.sleep(5000);
                if (channelFuture.isSuccess()) {
                    channelFuture.channel().writeAndFlush(Unpooled.wrappedBuffer("Hello\r\n".getBytes()));
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Try Starting Server First !!");
            }
            finally {
            }
        }
    }
}
