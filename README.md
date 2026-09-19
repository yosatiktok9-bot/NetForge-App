# NetForge — Private Routing, Plainly Done

**Version 1.0** | Kotlin / Jetpack Compose | 7 connection modes

Clean-room Android VPN client. Package: `com.netforge.app`.

## Features

- Modes: Direct, Wrapped, Wrapped+, SlowDNS, WebSocket, SslChain, Shadowsocks
- Real tunnels (SSH/TLS/UDP53/WS)
- Battery-aware foreground service + wake locks + boot auto-connect
- Profile import/export (`.nfg`)
- Live metrics, device-bound profiles
- Material 3 dark theme (Dusk)

## Build

```bash
git clone https://github.com/yosatiktok9-bot/NetForge-App.git
cd NetForge-App
./gradlew assembleDebug
```

Requires JDK 17+, Android SDK 34, Gradle 8.7.

## Structure

- `app/src/main/java/com/netforge/app/` — Application, VPN service, domain, data, UI
- `gradle/libs.versions.toml` — dependency catalog
- `.github/workflows/android.yml` — CI

See `SERVER_GUIDE.md` for server-side notes.

MIT — Axiom Collective
