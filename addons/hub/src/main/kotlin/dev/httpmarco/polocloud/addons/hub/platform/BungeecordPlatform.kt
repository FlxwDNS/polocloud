package dev.httpmarco.polocloud.addons.hub.platform

import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Command
import net.md_5.bungee.api.plugin.Plugin

class BungeecordPlatform: Plugin() {
    override fun onEnable() {
        ProxyServer.getInstance().pluginManager.registerCommand(this, BungeecordHubCommand())
    }
}

class BungeecordHubCommand: Command("hub", null, "lobby", "l", "h", "hubschrauber") {
    override fun execute(sender: CommandSender, args: Array<String>) {
        if(sender is ProxiedPlayer) {
            val player = sender
            player.disconnect("§7Connecting to fallback§8...")
            return
        }
        sender.sendMessage("§cThis command can only be executed as an player§8!")
    }

}