java  -XX:AOTMode=create -XX:AOTConfiguration=app.aotconf \
       -XX:AOTCache=app.aot  -cp target/benchmarks.jar dev.morling.onebrc.CalculateAverage_thomaswue  --worker
