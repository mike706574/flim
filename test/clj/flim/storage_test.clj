(ns flim.storage-test
  (:require [clojure.test :refer :all]
            [flim.io :as io]
            [clojure.zip :as zip]
            [flim.storage :as storage]))

(deftest file-type?
  (is (true? (storage/file-type? [".txt"] "foo.txt")))
  (is (false? (storage/file-type? [".txt"] "foo.gif")))
  (is (true? (storage/file-type? [".txt" ".gif"] "foo.gif"))))

(deftest classify-file?
  (is (= :video (storage/classify-file "foo.avi")))
  (is (= :subtitles (storage/classify-file "foo.srt")))
  (is (= :other (storage/classify-file "foo.gif"))))