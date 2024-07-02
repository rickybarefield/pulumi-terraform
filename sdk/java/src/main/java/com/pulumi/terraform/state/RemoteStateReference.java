package com.pulumi.terraform.state;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.internal.OutputCompletionSource;
import com.pulumi.resources.CustomResource;
import com.pulumi.resources.CustomResourceOptions;
import lombok.Data;

import java.util.Map;

/**
 * Manages a reference to a Terraform Remote State. The root outputs of the remote state are available
 * via the {@link #getOutput(String)} or {@link #getOutput(Output)} methods.
 */
public class RemoteStateReference extends CustomResource {
    /**
     * The root outputs of the referenced Terraform state.
     */
    @Export(name = "outputs", refs = {Map.class, String.class, Object.class}, tree = "[0, 1, 2]")
    public Output<Map<String, Object>> outputs;

    /**
     * Create a RemoteStateReference resource with the given unique name, arguments, and options.
     *
     * @param name The unique name of the remote state reference.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RemoteStateReference(String name, RemoteStateReferenceArgs args) {
        super("terraform:state:RemoteStateReference",
                name,
                args,
                CustomResourceOptions.builder().id(name).build());
    }

    /**
     * Create a RemoteStateReference resource with the given unique name, arguments, and options.
     *
     * @param name    The unique name of the remote state reference.
     * @param args    The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RemoteStateReference(String name, RemoteStateReferenceArgs args, CustomResourceOptions options) {
        super("terraform:state:RemoteStateReference",
                name,
                args,
                CustomResourceOptions.merge(options, CustomResourceOptions.builder().id(name).build()));
    }

    /**
     * Fetches the value of a root output from the Terraform Remote State.
     *
     * @param name The name of the output to fetch. The name is formatted exactly as per
     *             the "output" block in the Terraform configuration.
     * @return
     */
    public Output<Object> getOutput(String name) {

        return getOutput(Output.of(name));
    }

    /**
     * Fetches the value of a root output from the Terraform Remote State.
     *
     * @param name The name of the output to fetch. The name is formatted exactly as per
     *             the "output" block in the Terraform configuration.
     * @return
     */
    public Output<Object> getOutput(Output<String> name) {

        return Output.tuple(name, outputs).applyValue(both -> both.t2.get(both.t1));
    }

    public Output<Map<String, Object>> getOutputs() {
        return outputs;
    }

    public void setOutputs(Output<Map<String, Object>> outputs) {
        this.outputs = outputs;
    }
}
    