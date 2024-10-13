let
  sources = import ./nix/sources.nix;
  pkgs = import sources.nixpkgs { };
in pkgs.mkShell {
  buildInputs = with pkgs; [
    openjdk
    (sbt.override { jre = openjdk; })
    nodejs_20
  ];
}
