#!/bin/bash 

echo "=========================================================================="
echo "Installing NPM"
echo ""
echo "=========================================================================="

cd npm
npm install

cd src/angular
npm install

cd ../bootstrap
npm install

echo "========== Successful Install ============"


