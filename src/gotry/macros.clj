(ns gotry.macros)

(defn- compiletime-info
  [and-env and-form ns]
  (let [meta-info (meta and-form)]
    {:ns (str (ns-name ns))
     :line (:line meta-info)
     :file (:file meta-info)
     ;;:env and-env
     }))

(defmacro gotry [& body] 
  `(cljs.core.async.macros/go
     (try
       (do
         (prn "@macro" (merge {:some "FU"} ~(compiletime-info &env &form *ns*)))
         ~@body) 
       (catch js/Object e# 
         (prn "An exception has occured")))))


