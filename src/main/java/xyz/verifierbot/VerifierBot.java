package xyz.verifierbot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import xyz.verifierbot.EventListeners.Middleware;

public class VerifierBot {
    private final Dotenv config;
    private final ShardManager shardManager;

    public VerifierBot() {
        config = Dotenv.configure().filename("credentials.env").load();
        String TOKEN = config.get("TOKEN");
        int TOTAL_SHARD_COUNT = Integer.parseInt(config.get("SHARD_COUNT"));
        DefaultShardManagerBuilder shardManagerBuilder = DefaultShardManagerBuilder.createDefault(TOKEN);
        shardManagerBuilder
                .setShardsTotal(TOTAL_SHARD_COUNT)
                .setShards(0, TOTAL_SHARD_COUNT - 1)
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.listening("/help"))
                .enableIntents(
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.MESSAGE_CONTENT,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_MODERATION)
                .setMemberCachePolicy(MemberCachePolicy.DEFAULT)
                .setChunkingFilter(ChunkingFilter.ALL).addEventListeners(new Middleware());
        shardManager = shardManagerBuilder.build();
    }

    public Dotenv getConfig() {
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
}
