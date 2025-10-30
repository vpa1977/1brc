java  -XX:AOTMode=create -XX:AOTConfiguration=app.aotconf \
       -XX:AOTCache=app.aot  -cp target/average-1.0.0-SNAPSHOT.jar dev.morling.onebrc.CalculateAverage_thomaswue  --worker
