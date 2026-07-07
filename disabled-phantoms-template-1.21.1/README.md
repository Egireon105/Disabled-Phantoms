# Disabled Phantoms

A **Fabric** mod for **Minecraft 1.21.1** that allows every player to individually enable or disable phantom spawning.

---

## 🎯 Features

- **Individual settings** — each player controls phantom spawning for themselves.
- **Command `/phantoms spawn true/false`** — turns phantom spawning on or off.
- **Settings persist** — even after restarting the game or server.
- **Works on servers** — settings apply per player, independently.

---

## 📋 How it works

- If spawning is enabled (`true`), phantoms spawn as usual (after 3 days without sleeping).
- If spawning is disabled (`false`), phantoms **will not** spawn because of that player.
- If two players with different settings are nearby, phantoms can still spawn due to the player who has spawning enabled, and they may attack both.

---

## 🕹️ Commands

| Command | Description |
|---------|-------------|
| `/phantoms spawn true`  | Enable phantom spawning |
| `/phantoms spawn false` | Disable phantom spawning |

---

## ⚙️ Requirements

- **Minecraft:** 1.21.1
- **Loader:** Fabric
- **Fabric API** (automatically included)

---

## 📦 Installation

1. Download the latest version of the mod (available on [Modrinth](#) or [GitHub Releases](#)).
2. Place the JAR file into your `mods` folder.
3. Launch the game or server.

---

## 🔧 Building from source

```bash
./gradlew build
