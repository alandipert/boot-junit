(ns radicalzephyr.boot-junit
  {:boot/export-tasks true}
  (:require '[[boot.core :as core]])
  (:import org.junit.runner.JUnitCore))

(defn destructure-results [result]
  {})

(deftask junit
  "Run the jUnit test runner."
  [p packages PACKAGE #{sym} "The set of Java packages to run tests in."]
  (with-pre-wrap fileset
    (let [result (JUnitCore/runClasses
                  (into-array [#_ (magic goes here to find all test classes)]))]
      (when (> (.getFailureCount result) 0)
        (throw (ex-info "There were some test failures."
                        (destructure-results result)))))
    fileset))
