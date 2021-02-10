//
//  ContentView.swift
//  kt44808
//
//  Created by Sebastian Sellmair on 09.02.21.
//

import SwiftUI
import p1

struct ContentView: View {
    init() {
        MyApi().sayHello()
    }
    var body: some View {
        Text(MyApi().whoAmI()).padding()
        Text(MyApi().additionalApi())
        Text(MyApi().x1())
        Text(MyApi().x2())
        Text(MyApi().x8())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
