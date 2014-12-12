(defproject datascript-todo "0.1.0"
  :global-vars  {*warn-on-reflection* true}

  :dependencies [
    [org.clojure/clojure "1.7.0-alpha4"]
    [org.clojure/clojurescript "0.0-2411"]
    [datascript "0.6.0"]
    [sablono "0.2.22"]
    [com.facebook/react "0.11.2"]
  ]

  :plugins [
    [lein-cljsbuild "1.0.3"]
  ]

  :cljsbuild { 
    :builds [
      { :id "release"
        :source-paths  ["src"]
        :compiler {
          :externs       ["react/externs/react.js"]
          :output-to     "web/todo.min.js"
          :optimizations :advanced
          :pretty-print  false
        }}
  ]}
  
  :profiles {
    :dev {
      :cljsbuild {
        :builds [
          { :id "dev"
            :source-paths  ["src"]
            :compiler {
              :output-to     "web/todo.js"
              :output-dir    "web/out"
              :optimizations :none
              :source-map    true
            }}
      ]}
    }
  }
)
