package org.alessio;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestTimingExtension implements TestWatcher, TestExecutionExceptionHandler {

    private long startTime;

    // Metodo chiamato quando un test inizia
    @Override
    public void testSuccessful(ExtensionContext context) {
        long endTime = System.nanoTime(); // Registra il tempo finale
        System.out.println("Test completato: " + context.getDisplayName());
        System.out.println("Durata del test: " + (endTime - startTime) / 1_000_000 + " millisecondi");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        long endTime = System.nanoTime(); // Registra il tempo finale
        System.out.println("Test fallito: " + context.getDisplayName());
        System.out.println("Durata del test: " + (endTime - startTime) / 1_000_000 + " millisecondi");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        long endTime = System.nanoTime(); // Registra il tempo finale
        System.out.println("Test abortito: " + context.getDisplayName());
        System.out.println("Durata del test: " + (endTime - startTime) / 1_000_000 + " millisecondi");
    }

    // Metodo chiamato quando il test inizia
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        startTime = System.nanoTime(); // Registra il tempo iniziale
        throw throwable; // Propaga l'eccezione per gestirla nei test
    }
}
