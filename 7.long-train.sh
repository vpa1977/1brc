java  -XX:+UnlockDiagnosticVMOptions \
    -XX:-TieredCompilation \
    -XX:AOTCacheOutput=foo/big-app.aot -cp target/benchmarks.jar:target/loop.jar Loop  --worker
