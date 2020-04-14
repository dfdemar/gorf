#!/bin/bash

## Ensure the starting point is at the project root
cd "$(dirname "$0")/.."

## Determine which module to create
if [ -z $1 ]; then
  echo ""
  echo "USAGE: ${0} <module-name>"
  echo ""
  exit -1
fi;
MODULE=$1

## Verify module does not already exist
if [ -d $1 ]; then
  echo " ERROR: Cannot setup module that already exists ${MODULE}!"
  echo ""
  exit -1
fi

## Get the current date
DATE=`date +%D`

## Ask for description
echo "Please enter a description:"
read DESCRIPTION

## Ask for team name
echo "Please enter the name of your team:"
read TEAMNAME

## Ask for Developer Name
echo "Please enter your full name:"
read DEVELOPERNAME

## Ask for Developer Email
echo "Please enter your e-mail address:"
read DEVELOPEREMAIL

## Verify input
echo ""
echo "##### Creating ${MODULE} #####"
echo "## Description: ${DESCRIPTION}"
echo "## Team Name: ${TEAMNAME}"
echo "## Developer Name: ${DEVELOPERNAME}"
echo "## Developer E-mail: ${DEVELOPEREMAIL}"
echo ""
echo "Is this correct? (Y/N)"
read CORRECT

## If not correct, just exit
if [ $CORRECT != "Y" ] && [ $CORRECT != "y" ]; then
  echo "Not creating!"
  exit -1;
fi;

## Copy over template to root directory
cp -rp build/templates/module-template $MODULE

## Rewrite module's pom
sed "s/%%MODULE%%/${MODULE}/g; s/%%TEAMNAME%%/${TEAMNAME}/g; s/%%DESCRIPTION%%/${DESCRIPTION}/g; s/%%DEV_NAME%%/${DEVELOPERNAME}/g; s/%%DEV_EMAIL%%/${DEVELOPEREMAIL}/g; s#%%DATE%%#${DATE}#g;" < ${MODULE}/pom.template.xml > ${MODULE}/pom.xml
rm -f ${MODULE}/pom.template.xml

## Rewrite top level pom
MODULE_STR="    \<module\>${MODULE}\<\/module\>"
sed -i.bak "s/<\/modules\>/$MODULE_STR\
    \<\/modules\>/g" pom.xml

## Rewrite README.md
sed "s/%%MODULE%%/${MODULE}/g; s/%%TEAMNAME%%/${TEAMNAME}/g; s/%%DESCRIPTION%%/${DESCRIPTION}/g; s/%%DEV_NAME%%/${DEVELOPERNAME}/g; s/%%DEV_EMAIL%%/${DEVELOPEREMAIL}/g; s#%%DATE%%#${DATE}#g;" < ${MODULE}/README.template.md > ${MODULE}/README.md
rm -f ${MODULE}/README.template.md

## Rewrite CHANGELOG.md
sed "s/%%MODULE%%/${MODULE}/g; s/%%TEAMNAME%%/${TEAMNAME}/g; s/%%DESCRIPTION%%/${DESCRIPTION}/g; s/%%DEV_NAME%%/${DEVELOPERNAME}/g; s/%%DEV_EMAIL%%/${DEVELOPEREMAIL}/g; s#%%DATE%%#${DATE}#g;" < ${MODULE}/CHANGELOG.template.md > ${MODULE}/CHANGELOG.md
rm -f ${MODULE}/CHANGELOG.template.md
