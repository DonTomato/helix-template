(ns my-app.app
  (:require ["react-dom/client" :as rdom]
            [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]))

(defnc app []
  (<>
   (d/h1 "My App")))

(defonce root-storage (atom nil))

(defn start []
  (let [root (rdom/createRoot (js/document.getElementById "app"))]
    (reset! root-storage root) 
    (.render root ($ app))))

;; This is just for HMR
(defn stop [] 
  (.unmount @root-storage)
  (js/console.log "stop"))

(defn ^:export init []
  (start))