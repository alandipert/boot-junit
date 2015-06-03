(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojure         "1.6.0"  :scope "provided"]
                 [boot/core                   "2.1.0"  :scope "provided"]
                 [junit                       "4.12"   :scope "test"]
                 [org.reflections/reflections "0.9.10" :scope "test"]
                 [org.glassfish/javax.servlet "3.0"    :scope "test"]
                 [radicalzephyr/clansi        "1.2.0"  :scope "test"]])

(require '[radicalzephyr.boot-junit :refer [junit]])

(def +version+ "0.1.0")

(task-options!
 pom  {:project     'radicalzephyr/boot-junit
       :version     +version+
       :description "Run some jUnit tests in boot!"
       :url         "https://github.com/radicalzephyr/boot-junit"
       :scm         {:url "https://github.com/radicalzephyr/boot-junit"}
       :license     {"Eclipse Public License"
                     "http://www.eclipse.org/legal/epl-v10.html"}}
 junit {:packages '#{radicalzephyr.boot_junit.test}})
