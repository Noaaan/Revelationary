package de.dafuqs.revelationary.networking;

import de.dafuqs.revelationary.RevelationRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class RevelationaryS2CPacketSenders {
	
	public static void sendRevelations(ServerPlayerEntity player) {
		PacketByteBuf packetByteBuf = PacketByteBufs.create();
		RevelationRegistry.write(packetByteBuf);
		// silly packet handling workaround
		ServerPlayNetworking.send(player, new RevelationaryPackets.RevelationSync(new RegistryByteBuf(packetByteBuf, null)));
	}
	
}
