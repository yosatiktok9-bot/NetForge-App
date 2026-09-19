# NetForge ProGuard
-keepattributes *Annotation*
-keep class com.netforge.app.** { *; }
-dontwarn org.bouncycastle.**
-dontwarn net.schmizz.sshj.**
