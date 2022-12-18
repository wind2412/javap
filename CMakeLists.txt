cmake_minimum_required(VERSION 3.21)
project(javap)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(javap
        class_main.cc
        class_parser.cpp
        class_parser.hpp)

add_custom_command(
        TARGET javap POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E copy
        ${CMAKE_SOURCE_DIR}/classfiles/*
        ${CMAKE_CURRENT_BINARY_DIR}/)