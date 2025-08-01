package dev.httpmarco.polocloud.addons.hub.platform

import com.google.inject.Inject
import com.velocitypowered.api.command.SimpleCommand
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import net.kyori.adventure.text.Component
import org.slf4j.Logger

@Plugin(
    id = "polocloud-hub",
    name = "Polocloud-Hub",
    version = "3.0.0-SNAPSHOT",
    authors = ["Polocloud"],
    url = "https://github.com/HttpMarco/polocloud",
    description = "Polocloud-Hub"
)
class VelocityPlatform @Inject constructor(val proxyServer: ProxyServer, logger: Logger) {
    @Subscribe
    fun onProxyInitialize(event: ProxyInitializeEvent) {
        this.proxyServer.commandManager.register(
            this.proxyServer.commandManager.metaBuilder("hub")
            .aliases("lobby", "l", "h", "hubschrauber")
            .plugin(this)
            .build(), VelocityHubCommand()
        )
    }
}

class VelocityHubCommand: SimpleCommand {
    override fun execute(invocation: SimpleCommand.Invocation) {
        if(invocation is Player) {
            val player = invocation as Player
            player.disconnect(Component.text("§7Connecting to fallback§8..."))
            return
        }

        invocation.source().sendMessage(Component.text("§cThis command can only be executed as an player§8!"))
    }

}