#!/bin/bash

for adoc in `find . -name "*.adoc"`
do
	cd `dirname $adoc`
	asciidoctor `basename $adoc`
	cd $OLDPWD
done
