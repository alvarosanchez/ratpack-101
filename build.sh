#!/bin/bash

git checkout gh-pages
git merge master

for adoc in `find . -name "*.adoc"`
do
	cd `dirname $adoc`
	asciidoctor `basename $adoc`
	cd $OLDPWD
done

cp README.html index.html 
git add .
git commit -m "Updated files"
git push origin gh-pages
git checkout master
