{
 :config {:test-output "testoutput/"}
 :pipelines {"pipelineB" {:local-jar-path "target/"
                          :composer-class "com.acacia.timestamppipeline.TimestampComposer"}
             "pipelineC" {:local-jar-path "target/"
                          :composer-class "com.acacia.timestamppipeline.TimestampComposer"}
             "pipelineD" {:local-jar-path "target/"
                          :composer-class "com.acacia.timestamppipeline.TimestampComposer"}
             "pipelineE" {:local-jar-path "target/"
                          :composer-class "com.acacia.timestamppipeline.TimestampComposer"}
             "pipelineG" {:local-jar-path "target/"
                          :composer-class "com.acacia.timestamppipeline.TimestampComposer"}}
  :sources   {"sourceA" {:test-input "test-data/sourceA.json"}
              "sourceF" {:test-input "test-data/sourceF.json"}}
 }