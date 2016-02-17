{:sources   {"sourceF" {:type "gae"}}
 :edges     [{:origin "sourceF" :targets ["pipelineG"]}
             {:origin "pipelineG" :targets ["sinkG"]}]
 :pipelines {"pipelineG"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"
              :pail          "build-artifacts-public-eu"
              :key           "sossity-identity-pipeline-java"}
              }
 :sinks {"sinkG" {:type "gcs" :bucket "sinkG-test"}}}

