{:sources   {"sourceF" {:type "kub"}}
 :edges     [{:origin "sourceF" :targets ["pipelineG"]}
             {:origin "pipelineG" :targets ["sinkG"]}
             ]
 :pipelines {"pipelineG"
             {:transform-jar "timestamppipeline-bundled-0.1-ALPHA.jar"}}
 :sinks {"sinkG" {:type "gcs" :bucket "sinkG-test"}}
 }

