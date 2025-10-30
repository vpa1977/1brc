java  -XX:+UnlockDiagnosticVMOptions \
    -XX:-TieredCompilation \
    -XX:AOTCacheOutput=foo/big-app.aot -cp target/average-1.0.0-SNAPSHOT.jar:target/loop.jar Loop  --worker
