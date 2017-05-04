import io.netty.channel.ChannelFuture;

public class ServerFlow {
    public static ChannelFuture OpenServerPort(int port) {
        try {
            NettyServer nettyServer = new NettyServer(port);
            nettyServer.connectLoop();
            return nettyServer.getChannelFuture();
        } catch (Exception e) {
        }
        return null;
    }
}